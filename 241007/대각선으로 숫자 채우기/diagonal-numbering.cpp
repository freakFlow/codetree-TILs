#include <iostream>
using namespace std;

int main() {
    int n, m;
    int arr[100][100] = {};

    cin >> n >> m;

    int num = 1;
    for(int r=0; r<n; r++){
        for(int c=0; c<m; c++){
            if(arr[r][c] > 0) continue;
            arr[r][c] = num++;
            int row = r + 1;
            int col = c - 1;
            while(row < n && col >= 0){
                arr[row++][col--] = num++;
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