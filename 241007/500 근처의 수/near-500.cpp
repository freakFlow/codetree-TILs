#include <iostream>
using namespace std;

int main() {
    int num;
    int max = 0, min = 1001;

    for(int i=0; i<10; i++){
        cin >> num;
        if(num < 500){
            if(num > max) max = num;
        }else{
            if(num < min) min = num;
        }
    }

    cout << max << ' ' << min;

    return 0;
}