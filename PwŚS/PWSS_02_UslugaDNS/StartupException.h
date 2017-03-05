#pragma once

#include <WinSock2.h>
#include <exception>

using namespace std;

class StartupException :
	public exception
{
public:
	int err;
	char error[64];

	StartupException(int error);
	const char* what() throw();
	~StartupException();
};

