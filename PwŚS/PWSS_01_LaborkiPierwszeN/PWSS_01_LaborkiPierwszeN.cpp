// PWSS_01_LaborkiPierwszeN.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <winsock.h>
#include <locale.h>
#include <conio.h>
#include <iostream>
#include <string>

using namespace std;

int main()
{
	setlocale(LC_ALL, "Polish");

	WSADATA wsaData;

	struct hostent *remoteHost;
	struct in_addr addr;
	string host_name;
	DWORD dwError;


#pragma region inicjalizacja winsock
	int iResult;
	iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);

	if (iResult != 0) {
		printf("WSAStartup failed: %d\n", iResult);
		return 1;
	}
#pragma endregion

#pragma region nazwa hosta


	char buffer[64];
	if (gethostname(buffer, sizeof(buffer)) == SOCKET_ERROR)
	{
		printf("B³¹d funckji gethostname. Kod b³êdu %d.\n", WSAGetLastError());
	}
	else
	{
		printf("Nazwa komputera lokalnego: %s\n", buffer);
	}
#pragma endregion


	printf("Podaj nazwe hosta\n");
	cin >> host_name;
	//scanf("%s", host_name);
	remoteHost = gethostbyname(host_name.c_str());
	
	printf("Dla domeny %s zarejestrowano nastêpuj¹ce adresy IP:\n", remoteHost->h_name);
	int i = 0;
	while (remoteHost->h_addr_list[i])
	{
		addr.s_addr = *(u_long *)remoteHost->h_addr_list[i];
		printf("%s\n", inet_ntoa(addr));

		i++;
	}
	
	_getch();
	return 0;
}

