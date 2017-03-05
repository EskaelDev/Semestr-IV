#pragma once

#include <WinSock2.h>
#include <exception>

using namespace std;

class AdresyException :
	public exception
{
public:
	AdresyException();
	const char* what() throw();
	~AdresyException();
};

