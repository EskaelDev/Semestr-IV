#include "stdafx.h"
#include "IpAddress.h"


IpAddress::IpAddress()
{
}

void IpAddress::setAdresyDomeny(const char * hostname)
{
	adresy = gethostbyname(hostname);
	if (adresy == NULL)
		throw AdresyException();
}

char * IpAddress::operator[](int i)
{
	if (!adresy->h_addr_list[i])
		return NULL;
	addr.s_addr = *(u_long *)adresy->h_addr_list[i];
	return inet_ntoa(addr);
}


IpAddress::~IpAddress()
{
}
