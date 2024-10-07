#include <iostream>
using namespace std;

int main() {
    int arr1[3][3], arr2[3][3];

    for(int r=0; r<3; r++){
        for(int c=0; c<3; c++){
            cin >> arr1[r][c];
        }
    }

    for(int r=0; r<3; r++){
        for(int c=0; c<3; c++){
            cin >> arr2[r][c];
        }
    }

    for(int r=0; r<3; r++){
        for(int c=0; c<3; c++){
            cout << arr1[r][c] * arr2[r][c] << ' ';
        }
        cout << endl;
    }

    return 0;
}