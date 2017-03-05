#pragma once
#include "AdresyException.h"
class IpAddress
{
	struct hostent* adresy;
	in_addr addr;
public:
	IpAddress();

	void setAdresyDomeny(const char* hostname);
	char* operator[] (int i);
	~IpAddress();
};

