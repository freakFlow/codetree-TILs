#include <iostream>
#include <string>
using namespace std;

int main() {
    int n;
    string arr[20];
    char ch;
    int cnt = 0, len = 0;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    cin >> ch;

    for(int i=0; i<n; i++){
        if(arr[i][0] == ch){
            cnt++;
            len += arr[i].length();
        }
    }

    cout << fixed;
    cout.precision(2);

    cout << cnt << ' ' << (double)len / cnt;

    return 0;
}