#include <stdio.h>
using namespace std;

// FUNCTION POINTERS in C / C++
int Add (int a, int b) {
  return a+b;
}

int main () {
  int (*p) (int, int);
  p = &Add;
  
  int c = (*p) (2, 3); // De-referencing and using the function
  printf ("%d", c);
}

/*

int *func (int, int); // this is declaring a function that would return int

int (*func) (int, int); // this is declaring a function pointer


*/
