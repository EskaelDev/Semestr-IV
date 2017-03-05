#include "stdafx.h"
#include "StartupException.h"

StartupException::StartupException(int error) : err(error)
{
}

const char * StartupException::what() throw()
{
	sprintf(error, "Nieudana inicjalizacja biblioteki WinSock. Kod bledu: %d", err);
	return error;
	return nullptr;
}

StartupException::~StartupException()
{
}
