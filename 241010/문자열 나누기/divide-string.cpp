#include <iostream>
#include <string>
using namespace std;

int main() {
    int n;
    string str, ans = "";

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> str;
        ans += str;
    }

    for(int i=0; i<ans.length(); i++){
        cout << ans[i];
        if(i % 5 == 4) cout << endl;
    }

    return 0;
}