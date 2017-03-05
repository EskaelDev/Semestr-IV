#include "stdafx.h"
#include "WinSockInit.h"


WinSockInit::WinSockInit()
{
	int result = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (result != NO_ERROR)
		throw StartupException(result);
	cout << "\nBliblioteka WinSock zainicjalizowana poprawnie." << endl;
}


WinSockInit::~WinSockInit()
{
	WSACleanup();
	cout << "\nUsunieto z pamieci biblioteke WinSock." << endl;
}
