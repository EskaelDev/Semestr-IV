// PWSS_02_UslugaDNS.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include <locale.h>
#include <conio.h>

#include "IpAddress.h"
#include "WinSockInit.h"


void Wyswietl(IpAddress ipadr)
{
	int i = 0;
	while (ipadr[i])
		printf("adresy IP: %s\n", ipadr[i++]);
}

int main()
{
	try
	{
		WinSockInit WinSockLibInit = WinSockInit();
		IpAddress adresses = IpAddress();

		while (true)
		{
			static char adresDomeny[255];
			printf("Wprowadz nazwe domeny, z ktorej chcesz pobrac adresy. Pusty znak oznacza koniec.\nDomena: ");
			gets_s(adresDomeny);

			if (strlen(adresDomeny) == 0)
			{
				printf("\nZakonczenie programu.\n");
				system("pause");
				return 0;
			}
			try
			{
				adresses.setAdresyDomeny(adresDomeny);
				Wyswietl(adresses);
			}
			catch (AdresyException &e)
			{
				cout << e.what() << " " << WSAGetLastError() << endl;	// przechwytujemy wyj¹tek w razie nieprawid³owego adresu domeny
			}
		}
	}
	catch (StartupException &e)
	{
		cout << e.what() << endl;
		system("pause");
		return 0;
	}
	system("pause");
	return 0;
}



