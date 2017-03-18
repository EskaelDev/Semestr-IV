// UDP komunikacja prsota.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <conio.h>
#include <cstdio>
//#include <WinSock2.h>
#include <iostream>
#include <winsock2.h>

#pragma comment(lib, "ws2_32.lib")

using namespace std;


class wyjatek
{
	DWORD dwError;
public:
	wyjatek(int iResult)
	{
		printf("Winsock - Blad nr %d", iResult);
	}

	wyjatek(hostent *rH)
	{
		dwError = WSAGetLastError();
		if (dwError == WSAHOST_NOT_FOUND)
		{
			printf("host not found");
		}
		else if (dwError = WSANO_DATA)
		{
			printf("no data record");
		}
		else
		{
			printf("failed %d", dwError);
		}
	}
};

class TInicjalizacja
{
	int iResult;
	WSAData wsaData;
	int dwError;
public:
	TInicjalizacja()
	{
		iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);
		if (iResult != 0)
		{

			throw wyjatek(iResult);
		}
		else
		{
			//	printf ("Winosck jest oki\n");
		}
	}
	~TInicjalizacja()
	{
		WSACleanup();
	}

};

class THost
{
	int iResult;
	DWORD dwError;
	hostent *rH;
	char hostname[100];
	sockaddr_in serwer;
	sockaddr_in klient;
public:
	THost(const char *nazwa)
	{
		strcpy(hostname, nazwa);
		rH = gethostbyname(hostname);
		if (rH == NULL) throw wyjatek(rH);
		else
		{
			serwer.sin_family = AF_INET;
			serwer.sin_port = htons(27015);
			serwer.sin_addr.s_addr = inet_addr(hostname);

			//
			klient.sin_family = AF_INET;
			klient.sin_port = htons(300);
		}
	}

	hostent ZwrocHostent()
	{
		return *rH;
	}

	sockaddr_in Zwrocserwer()
	{
		return serwer;
	}

	sockaddr_in Zwrocklient()
	{
		return klient;
	}

};

int _tmain(int argc, _TCHAR* argv[])
{

	TInicjalizacja TW;
	
	SOCKET Client;
	Client = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
	if (Client == INVALID_SOCKET)
	{
		cout << "Nie mozna stworzyc socket" << endl;
		getch();
		return 1;
	}

	char host[128] = "192.168.1.5";
	THost Th(host);
	char ciag[1024];

	char buff2[1024];
	int buffLen = 1024;
	int AddrSize; //= sizeof (Addr);

	int wynik;

	do
	{
		cout << "Podaj wartosc do wyslania\n";
		gets_s(ciag);
		if (!stricmp(ciag, "exit"))
		{
			shutdown(Client, 2);
			closesocket(Client);
			break;
		}

		int wynik = sendto(Client, ciag, strlen(ciag), 0, (SOCKADDR*)&Th.Zwrocserwer(), sizeof(Th.Zwrocserwer()));
		if (wynik == INVALID_SOCKET)
		{
			cout << "Blad wysylania nr:" << WSAGetLastError();
			shutdown(Client, 2);
			closesocket(Client);
			getch();
			return 1;
		}

		AddrSize = sizeof(Th.Zwrocklient());

		wynik = recvfrom(Client, buff2, buffLen, 0, (SOCKADDR*)&Th.Zwrocklient(), &AddrSize);
		buff2[wynik] = 0;

		if (wynik == INVALID_SOCKET)
		{
			cout << "Blad odbeirania nr" << WSAGetLastError();
			shutdown(Client, 2);
			closesocket(Client);
			getch();
			return 0;
		}

		cout << "Tresc odeslana		: " << buff2 << endl;
		cout << "Adres			: " << Th.ZwrocHostent().h_name << endl;
		cout << "Port odbiorcy		: " << ntohs(Th.Zwrocklient().sin_port) << endl;
		cout << "Port nadawcy		: " << ntohs(Th.Zwrocserwer().sin_port) << endl << endl;
	} while (true);

	cout << "Koniec programu" << endl;
	getch();
	return 0;

}