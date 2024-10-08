#include <iostream>
using namespace std;

int main() {
    int arr[5][5];

    for(int i=0; i<5; i++){
        arr[i][0] = 1;
        arr[0][i] = 1;
    }

    for(int r=1; r<5; r++){
        for(int c=1; c<5; c++){
            arr[r][c] = arr[r-1][c] + arr[r][c-1];
        }
    }

    for(int r=0; r<5; r++){
        for(int c=0; c<5; c++){
            cout << arr[r][c] << ' ';
        }
        cout << endl;
    }

    return 0;
}