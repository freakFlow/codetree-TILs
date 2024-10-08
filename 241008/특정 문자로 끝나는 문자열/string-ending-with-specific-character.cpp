#include <iostream>
#include <string>
using namespace std;

int main() {
    string arr[10];
    char ch;
    int cnt = 0;

    for(int i=0; i<10; i++){
        cin >> arr[i];
    }

    cin >> ch;
    for(int i=0; i<10; i++){
        if(arr[i][arr[i].length()-1] == ch){
            cout << arr[i] << endl;
            cnt++;
        }
    }

    if(cnt == 0) cout << "None";

    return 0;
}