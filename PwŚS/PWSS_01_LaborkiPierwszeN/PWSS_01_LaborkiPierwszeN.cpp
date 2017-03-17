// PWSS_01_LaborkiPierwszeN.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <winsock.h>
#include <locale.h>
#include <conio.h>
#include <iostream>
#include <string>

using namespace std;

// Klasa wyj�tku obs�uguj�ca nieprawid�ow� inicjalizacj� biblitoeki sieciowej WinSock
class StartupException : public exception
{
public:
	int err;
	char error[60];	// zmienna przechowuj�ca tekstowy
	StartupException(int error) : err(error) {}
	const char* what() throw()	// przeci��anie metody what klasy exception, czyli piszemy w�asn� wersj�
	{
		// formatujemy komunikat wyj�tku wstawiaj�c do niego kod b��du wygenerowany z zewn�trz (err)
		sprintf(error, "Nieudana inicjalizacja biblioteki WinSock. Kod bledu: %d", err);
		return error;
	}
	~StartupException() {}
};

// Klasa wyj�tku obs�uguj�ca nieprawid�owy adres
class AdresyException : public exception
{
public:
	AdresyException() {}
	const char* what() throw()
	{
		return "Blad pobrania adresow: ";
	}
};

// Klasa obs�uguj�ca inicjalizacj� biblioteki sieciowej WinSock
class WinSockInit
{
	struct hostent* adresy;	// struktura przechowuj�ca informacje o adresach pobranych dla danej domeny
	in_addr addr;		// struktura przechowuj�ca informacje o adresie
	WSADATA wsaData;
public:
	WinSockInit()
	{
		int result = WSAStartup(MAKEWORD(2, 2), &wsaData);
		if (result != NO_ERROR)	// je�li inicjalizacja si� nie powiod�a to rzucamy naszym wyjatkiem
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
		if (adresy == NULL)		// je�li nie uda�o si� pobra� informacji to rzucamy wyj�tkiem
			throw AdresyException();
	}
	char* operator[] (int i)	// przeci��anie operatora indeksowania
	{
		if (!adresy->h_addr_list[i])	// je�li adres jest zerowy to zwracamy null. Oznacza to brak dalszych adres�w
			return NULL;
		addr.s_addr = *(u_long *)adresy->h_addr_list[i];	// rzutujemy pobrany adres na posta� unsinged long
		return inet_ntoa(addr);		// konwersja na posta� �a�cucha znak�w (adres IP w�a�ciwy)
	}
};
/*
class IpAddreses
{
private:
	struct hostent* adresy;	// struktura przechowuj�ca informacje o adresach pobranych dla danej domeny
	in_addr addr;		// struktura przechowuj�ca informacje o adresie
public:
	IpAddreses() {}

	void setAdresyDomeny(const char* hostname)
	{
		adresy = gethostbyname(hostname);	// pobieramy informacje o adresach podanego hosta
		if (adresy == NULL)		// je�li nie uda�o si� pobra� informacji to rzucamy wyj�tkiem
			throw AdresyException();
	}

	char* operator[] (int i)	// przeci��anie operatora indeksowania
	{
		if (!adresy->h_addr_list[i])	// je�li adres jest zerowy to zwracamy null. Oznacza to brak dalszych adres�w
			return NULL;
		addr.s_addr = *(u_long *)adresy->h_addr_list[i];	// rzutujemy pobrany adres na posta� unsinged long
		return inet_ntoa(addr);		// konwersja na posta� �a�cucha znak�w (adres IP w�a�ciwy)
	}
	~IpAddreses() {}
};*/
// Funkcja wy�wietlaj�ca pobrane adresy z domeny. Korzysta ona z przeci��onego operatora indeksowania
void Wyswietl(WinSockInit ipadr)
{
	int i = 0;
	while (ipadr[i])	// P�tla iteruj�ca po adresach
		printf("Adresy IP: %s\n", ipadr[i++]);
}

int main()
{
	try
	{
		WinSockInit WinSockLibInit = WinSockInit();	// inicjalizacja WinSock
		//IpAddreses adresses = IpAddreses();			// przygotowanie obiektu przechowuj�cego adresy

		while (true)	// p�tla seteruj�ca cyklicznym pobieraniem domeny od u�ytkownika i wy�wietlaniem dla niej adres�w
		{
			static char adresDomeny[255];	// adres domeny podanej przez u�ytkownika
			printf("Wprowadz nazwe domeny, z ktorej chcesz pobrac adresy. Pusty znak oznacza koniec.\nDomena:  ");
			gets_s(adresDomeny);	//pobieramy adres domeny

			if (strlen(adresDomeny) == 0)	// je�li podano pusty ci�g znak�w to ko�czymy program
			{
				printf("\nZakonczenie programu.\n");
				system("pause");
				return 0;
			}
			try
			{
				WinSockLibInit.setAdresyDomeny(adresDomeny);	// wpisujemy do obiektu adres domeny
				Wyswietl(WinSockLibInit);			// wy�wietlamy skonwertowane ju� adresy na posta� ci�gu znak�w
			}
			catch (AdresyException &e)
			{
				cout << e.what() << " " << WSAGetLastError() << endl;	// przechwytujemy wyj�tek w razie nieprawid�owego adresu domeny
			}
		}
	}
	catch (StartupException &e)		// przechwytujemy wyj�tek w razie nieprawid�owej inicjalizacji WinSock
	{
		cout << e.what() << endl;
		system("pause");
		return 0;
	}

	system("pause");
	return 0;
}