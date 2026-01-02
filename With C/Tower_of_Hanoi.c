#include <stdio.h>
void towerOfHanoi(int *step_count, int n, char source, char help, char destination) // Recursive function to solve Tower of Hanoi
{
    if (n > 0) 
    {
        towerOfHanoi(step_count, n - 1, source, destination, help);// Move n-1 disks from source to help using destination
        printf("Step %2d : Move disk %d from %c to %c\n", ++(*step_count), n, source, destination);// Move the nth disk from source to destination
        towerOfHanoi(step_count, n - 1, help, source, destiation);// Move n-1 disks from help to destination using source
    }
}
int main() 
{
    int n, step_no = 0;  // directly initialized to 0
    printf("Enter the number of disks : ");
    scanf("%d", &n);
    printf("\nSequence of moves to solve Tower of Hanoi : \n\n");
    towerOfHanoi(&step_no, n, 'S', 'H', 'D');    // Solve Tower of Hanoi
    printf("\nTotal steps taken : %d\n", step_no);   
    return 0;
}
