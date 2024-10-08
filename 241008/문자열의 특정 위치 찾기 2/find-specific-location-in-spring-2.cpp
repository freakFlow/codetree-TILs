#include <iostream>
#include <string>
using namespace std;

int main() {
    string arr[5] = {"apple", "banana", "grape", "blueberry", "orange"};
    char ch;

    cin >> ch;

    int ans = 0;
    for(int i=0; i<5; i++){
        if(ch == arr[i][2] || ch == arr[i][3]){
            cout << arr[i] << endl;
            ans++;
        }
    }
    cout << ans;

    return 0;
}