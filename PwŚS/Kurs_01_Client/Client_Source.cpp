//Client
#pragma comment(lib, "ws_32.lib")
#include <WinSock2.h>
#include <iostream>

int main()
{
	// Start Winsock
	WSADATA wsaData;
	WORD DllVersion = MAKEWORD(2, 1);
	if (WSAStartup(DllVersion, &wsaData) != 0)
	{
		MessageBoxA(NULL, "Winsock start failed", "Error", MB_OK | MB_ICONERROR);
		exit(1);
	}
	return 0;
}