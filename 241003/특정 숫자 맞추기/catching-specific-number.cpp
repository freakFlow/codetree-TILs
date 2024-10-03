#include <iostream>
using namespace std;

int main() {
    int num;

    while(true){
        cin >> num;

        if(num == 25){
            cout << "Good";
            break;
        }else if(num < 25){
            cout << "Higher\n";
        }else{
            cout << "Lower\n";
        }
    }

    return 0;
}