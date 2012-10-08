/* exploit.c*/
/* A program that creates a file containing code for launching shell*/
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void main(int argc, char **argv)
{
	int x = 0;
	printf("%x\n", &x);
}
