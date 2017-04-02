#include <winsock2.h>
#include <conio.h>
#include <stdio.h>
#include <vector>
#include <string>


using namespace std;

#pragma comment(lib, "ws2_32.lib")

int main()
{
	setlocale(LC_ALL, "");
	unsigned int lw, lk;
	unsigned int indeks = 0;
	float buf;
	char bufor[5];
	float tablica[50];
	unsigned char znak;

	WSAData ws;
	if (WSAStartup(MAKEWORD(2, 2), &ws) != 0)
		printf("WinSock error: %d\n", WSAGetLastError());
	else
		printf("Biblioteka WinSock zainicjalizowana poprawnie.\n");

	SOCKET s = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
	if (s == INVALID_SOCKET)
		printf("Socket error: %d\n", WSAGetLastError());
	else
	{
		printf("Gniazdo utworzono poprawnie.\n");

		sockaddr_in server;
		server.sin_family = AF_INET;
		server.sin_port = htons(7601);
		server.sin_addr.s_addr = inet_addr("192.168.0.13");

		sockaddr_in broadcast;
		broadcast.sin_family = AF_INET;
		broadcast.sin_addr.s_addr = inet_addr("255.255.255.255");
		broadcast.sin_port = htons(7601);

		char buffer[1024];

		char buff[7];
		buff[0] = 0x34;
		buff[1] = 2;
		buff[2] = 'P';
		buff[3] = 'i';
		buff[4] = 2;
		buff[5] = 'K';
		buff[6] = 'o';

		timeval time = { 0, 100000 };
		fd_set set;


		int n = sendto(s, buff, strlen(buff), 0, (sockaddr*)&broadcast, sizeof(broadcast));

		printf("Aby zakonczyc dzialanie programu, naciœnij Esc.\n");

		while (true)
		{

			FD_ZERO(&set);
			FD_SET(s, &set);
			if (select(0, &set, 0, 0, &time) > 0)
			{
				if (FD_ISSET(s, &set))
				{
					sockaddr_in addrFrom;
					int sizeAddrFrom = sizeof(addrFrom);
					n = recvfrom(s, buffer, sizeof(buffer), 0, (sockaddr*)&addrFrom, &sizeAddrFrom);
					if (n > 0)
					{
						buffer[n] = 0;
						printf("Odebrano: %s\n", buffer);
					}
				}
			}

			if (_kbhit())
			{
				znak = getch();

				if (znak == 27)
				{
					break;
				}

				if (znak == 13)
				{
					//enter: zadanie wizytowki do serwera
					printf("Enter!\n");
					char zadanie[2];
					zadanie[0] = 0x34;
					zadanie[1] = 0x02;
					int n = sendto(s, zadanie, 2, 0, (sockaddr*)&server, sizeof(server));
					if (n == 0) printf("B³ont! Nie uda³o siê wys³aæ ¿¹dania :<\n");
					else printf("Wys³ano ¿¹danie do serwera.\n");
				}

				if (znak == ' ')
				{
					//spacja: wyslanie wizytowki
					printf("Spacja!\n");
					int n = sendto(s, buff, 7, 0, (sockaddr*)&broadcast, sizeof(broadcast));
					if (n == 0) printf("B³ont! Nie uda³o siê wys³aæ wizytówki :<\n");
					else printf("Wys³ano wizytówkê.\n");
				}
			}

			/*printf(">");
			gets(buff);
			if(strcmp(buff, "exit") == 0)
			{
			break;
			}
			int n = sendto(s, buff, strlen(buff), 0, (sockaddr*) &server, sizeof(server));
			if(n > 0)
			{
			sockaddr_in addrFrom;
			int sizeAddrFrom = sizeof(addrFrom);
			n = recvfrom(s, buff, sizeof(buff) - 1, 0, (sockaddr*) &addrFrom, &sizeAddrFrom);
			if(n > 0)
			{
			buff[n] = 0;
			printf("Odebrano: %s\n", buff);

			buf = atof(buff);
			tablica[0] = buf;
			indeks++;
			printf("\n%f", buf);

			for (int i = 0; i < strlen(buff); i++)
			{

			/*if (buff[i] = ' ')
			{
			buf = sscanf(buff+i, "%f", tablica+indeks);
			tablica[indeks] = buf;
			indeks++;
			}
			else;


			//printf("%f ", buf);
			}

			for (int i = 0; i < indeks; i++)
			{
			printf("%f ", tablica[i]);
			}

			strncpy(porownanie, buff, 5);

			for (int i = 0; i < 5; i++)
			{
			if(strcmp(".", porownanie))
			{
			printf("\nOdczytano wektor.\n");
			}
			else printf("\nOdczytano macierz.\n");
			}
			}
			else
			printf("Recvfrom zwraca blad: %d\n", WSAGetLastError());
			}
			else
			printf("Sendto zwraca blad: %d\n", WSAGetLastError());*/
		}
	}

	if (shutdown(s, 2) == SOCKET_ERROR)
		printf("Blad konca transmisji\n");
	else
		printf("Transmisja wstrzymana.\n");
	if (closesocket(s) == SOCKET_ERROR)
		printf("Blad zamykania gniazda\n");
	else
		printf("Gniazdo zniszczone.\n");
	WSACleanup();
	_getch();
	return 0;
}

