#pragma once
#include "StartupException.h"
#include <iostream>

using namespace std;

class WinSockInit
{
	WSADATA wsaData;
public:
	WinSockInit();
	~WinSockInit();
};

