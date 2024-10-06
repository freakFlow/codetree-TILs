#include <iostream>
using namespace std;

int main() {
    int count[10] = {};
    int num;

    for(int i=0; i<100; i++){
        cin >> num;
        if(num == 0) break;
        if(num < 10) continue;

        count[num / 10 % 10]++;
    }

    cout << "100 - " << count[0] << endl;
    for(int i=9; i>0; i--){
        cout << i * 10 << " - " << count[i] << endl;
    }

    return 0;
}