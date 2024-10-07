#include <iostream>
using namespace std;

int main() {
    int arr[4][4];

    for(int i=0; i<4; i++){
        int sum = 0;
        for(int c=0; c<4; c++){
            cin >> arr[i][c];
            sum += arr[i][c];
        }
        cout << sum << endl;
    }

    return 0;
}