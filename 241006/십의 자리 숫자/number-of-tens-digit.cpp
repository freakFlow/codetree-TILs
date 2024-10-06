#include <iostream>
using namespace std;

int main() {
    int count[10] = {};
    int num;

    for(int i=0; i<100; i++){
        cin >> num;
        if(num == 0) break;

        count[num / 10 % 10]++;
    }

    for(int i=1; i<10; i++){
        cout << i << " - " << count[i] << endl;
    }

    return 0;
}