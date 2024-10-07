#include <iostream>
using namespace std;

int main() {
    int n, m;
    int arr[100][100];

    cin >> n >> m;

    int num = 0;

    for(int c=0; c<m; c++){
        if(c % 2 == 0){
            for(int r=0; r<n; r++){
                arr[r][c] = num++;
            }
        }else{
            for(int r=n-1; r>=0; r--){
                arr[r][c] = num++;
            }
        }
    }

    for(int r=0; r<n; r++){
        for(int c=0; c<m; c++){
            cout << arr[r][c] << ' ';
        }
        cout << endl;
    }

    return 0;
}