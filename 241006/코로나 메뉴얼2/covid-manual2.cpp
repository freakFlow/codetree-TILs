#include <iostream>
using namespace std;

int main() {
    int count[4] = {};
    char ch;
    int num;

    for(int i=0; i<3; i++){
        cin >> ch >> num;
        if(ch == 'Y'){
            if(num >= 37) count[0]++;
            else count[2]++;
        }else if(num >= 37) count[1]++;
        else count[3]++;
    }

    for(int i=0; i<4; i++){
        cout << count[i] << ' ';
    }

    if(count[0] >= 2) cout << 'E';

    return 0;
}