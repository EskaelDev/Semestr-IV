// PWSS_01_LaborkiPierwszeN.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <winsock.h>
#include <locale.h>
#include <conio.h>
#include <iostream>
#include <string>

using namespace std;

// Klasa wyj¹tku obs³uguj¹ca nieprawid³ow¹ inicjalizacjê biblitoeki sieciowej WinSock
class StartupException : public exception
{
public:
	int err;
	char error[60];	// zmienna przechowuj¹ca tekstowy
	StartupException(int error) : err(error) {}
	const char* what() throw()	// przeci¹¿anie metody what klasy exception, czyli piszemy w³asn¹ wersjê
	{
		// formatujemy komunikat wyj¹tku wstawiaj¹c do niego kod b³êdu wygenerowany z zewn¹trz (err)
		sprintf(error, "Nieudana inicjalizacja biblioteki WinSock. Kod bledu: %d", err);
		return error;
	}
	~StartupException() {}
};

// Klasa wyj¹tku obs³uguj¹ca nieprawid³owy adres
class AdresyException : public exception
{
public:
	AdresyException() {}
	const char* what() throw()
	{
		return "Blad pobrania adresow: ";
	}
};

// Klasa obs³uguj¹ca inicjalizacjê biblioteki sieciowej WinSock
class WinSockInit
{
	struct hostent* adresy;	// struktura przechowuj¹ca informacje o adresach pobranych dla danej domeny
	in_addr addr;		// struktura przechowuj¹ca informacje o adresie
	WSADATA wsaData;
public:
	WinSockInit()
	{
		int result = WSAStartup(MAKEWORD(2, 2), &wsaData);
		if (result != NO_ERROR)	// jeœli inicjalizacja siê nie powiod³a to rzucamy naszym wyjatkiem
			throw StartupException(result);
		cout << "\nBiblioteka WinSock zainicjalizowana poprawnie." << endl;
	}
	~WinSockInit()	// Destruktor klasy
	{
		WSACleanup();	// zwolnienie biblioteki WinSock
		cout << "\nUsunieto z pamieci biblioteke WinSock." << endl;
	}
	void setAdresyDomeny(const char* hostname)
	{
		adresy = gethostbyname(hostname);	// pobieramy informacje o adresach podanego hosta
		if (adresy == NULL)		// jeœli nie uda³o siê pobraæ informacji to rzucamy wyj¹tkiem
			throw AdresyException();
	}
	char* operator[] (int i)	// przeci¹¿anie operatora indeksowania
	{
		if (!adresy->h_addr_list[i])	// jeœli adres jest zerowy to zwracamy null. Oznacza to brak dalszych adresów
			return NULL;
		addr.s_addr = *(u_long *)adresy->h_addr_list[i];	// rzutujemy pobrany adres na postaæ unsinged long
		return inet_ntoa(addr);		// konwersja na postaæ ³añcucha znaków (adres IP w³aœciwy)
	}
};
/*
class IpAddreses
{
private:
	struct hostent* adresy;	// struktura przechowuj¹ca informacje o adresach pobranych dla danej domeny
	in_addr addr;		// struktura przechowuj¹ca informacje o adresie
public:
	IpAddreses() {}

	void setAdresyDomeny(const char* hostname)
	{
		adresy = gethostbyname(hostname);	// pobieramy informacje o adresach podanego hosta
		if (adresy == NULL)		// jeœli nie uda³o siê pobraæ informacji to rzucamy wyj¹tkiem
			throw AdresyException();
	}

	char* operator[] (int i)	// przeci¹¿anie operatora indeksowania
	{
		if (!adresy->h_addr_list[i])	// jeœli adres jest zerowy to zwracamy null. Oznacza to brak dalszych adresów
			return NULL;
		addr.s_addr = *(u_long *)adresy->h_addr_list[i];	// rzutujemy pobrany adres na postaæ unsinged long
		return inet_ntoa(addr);		// konwersja na postaæ ³añcucha znaków (adres IP w³aœciwy)
	}
	~IpAddreses() {}
};*/
// Funkcja wyœwietlaj¹ca pobrane adresy z domeny. Korzysta ona z przeci¹¿onego operatora indeksowania
void Wyswietl(WinSockInit ipadr)
{
	int i = 0;
	while (ipadr[i])	// Pêtla iteruj¹ca po adresach
		printf("Adresy IP: %s\n", ipadr[i++]);
}

int main()
{
	try
	{
		WinSockInit WinSockLibInit = WinSockInit();	// inicjalizacja WinSock
		//IpAddreses adresses = IpAddreses();			// przygotowanie obiektu przechowuj¹cego adresy

		while (true)	// pêtla seteruj¹ca cyklicznym pobieraniem domeny od u¿ytkownika i wyœwietlaniem dla niej adresów
		{
			static char adresDomeny[255];	// adres domeny podanej przez u¿ytkownika
			printf("Wprowadz nazwe domeny, z ktorej chcesz pobrac adresy. Pusty znak oznacza koniec.\nDomena:  ");
			gets_s(adresDomeny);	//pobieramy adres domeny

			if (strlen(adresDomeny) == 0)	// jeœli podano pusty ci¹g znaków to koñczymy program
			{
				printf("\nZakonczenie programu.\n");
				system("pause");
				return 0;
			}
			try
			{
				WinSockLibInit.setAdresyDomeny(adresDomeny);	// wpisujemy do obiektu adres domeny
				Wyswietl(WinSockLibInit);			// wyœwietlamy skonwertowane ju¿ adresy na postaæ ci¹gu znaków
			}
			catch (AdresyException &e)
			{
				cout << e.what() << " " << WSAGetLastError() << endl;	// przechwytujemy wyj¹tek w razie nieprawid³owego adresu domeny
			}
		}
	}
	catch (StartupException &e)		// przechwytujemy wyj¹tek w razie nieprawid³owej inicjalizacji WinSock
	{
		cout << e.what() << endl;
		system("pause");
		return 0;
	}

	system("pause");
	return 0;
}