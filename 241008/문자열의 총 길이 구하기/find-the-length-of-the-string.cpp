#include <iostream>
#include <string>
using namespace std;

int main() {
    string arr[10];
    int ans = 0;

    for(int i=0; i<10; i++){
        cin >> arr[i];
        ans += arr[i].length();
    }

    cout << ans;

    return 0;
}