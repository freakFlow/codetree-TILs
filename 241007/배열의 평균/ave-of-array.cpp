#include <iostream>
using namespace std;

int main() {
    int arr[2][4];

    for(int r=0; r<2; r++){
        for(int c=0; c<4; c++){
            cin >> arr[r][c];
        }
    }

    cout << fixed;
    cout.precision(1);
    for(int r=0; r<2; r++){
        int sum = 0;
        for(int c=0; c<4; c++){
            sum += arr[r][c];
        }
        cout << sum / 4.0 << ' ';
    }
    cout << endl;

    for(int c=0; c<4; c++){
        int sum = 0;
        for(int r=0; r<2; r++){
            sum += arr[r][c];
        }
        cout << sum / 2.0 << ' ';
    }

    cout << endl;

    int sum = 0;
    for(int r=0; r<2; r++){
        for(int c=0; c<4; c++){
            sum += arr[r][c];
        }
    }

    cout << sum / 8.0;

    return 0;
}