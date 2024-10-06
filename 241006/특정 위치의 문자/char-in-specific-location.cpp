#include <iostream>
using namespace std;

int main() {
    char arr[] = {'L', 'E', 'B', 'R', 'O', 'S'};
    int idx = -1;
    char ch;

    cin >> ch;

    for(int i=0; i<6; i++){
        if(arr[i] == ch) idx = i;
    }

    if(idx < 0) cout << "None";
    else cout << idx;

    return 0;
}