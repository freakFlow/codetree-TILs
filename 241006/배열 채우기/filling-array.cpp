#include <iostream>
using namespace std;

int main() {
    int arr[10];
    int lastIdx = -1;

    for(int i=0; i<10; i++){
        cin >> arr[i];
        if(arr[i] == 0){
            lastIdx = i - 1;
            break;
        }
    }

    if(lastIdx == -1) lastIdx = 9;

    for(int j=lastIdx; j>=0; j--){
        cout << arr[j] << ' ';
    }

    return 0;
}