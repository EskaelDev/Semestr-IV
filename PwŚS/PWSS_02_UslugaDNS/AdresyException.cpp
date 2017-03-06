#include "stdafx.h"
#include "AdresyException.h"


AdresyException::AdresyException()
{
}

const char * AdresyException::what() throw()
{
	return "Blad pobrania adresow: ";
}


AdresyException::~AdresyException()
{
}
