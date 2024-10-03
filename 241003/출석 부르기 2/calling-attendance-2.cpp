#include <iostream>
using namespace std;

int main() {
    int num;

    while(true){
        cin >> num;

        if(num == 1){
            cout << "John\n";
        }else if(num == 2){
            cout << "Tom\n";
        }else if(num == 3){
            cout << "Paul\n";
        }else if(num == 4){
            cout << "Sam\n";
        }else{
            cout << "Vacancy";
            break;
        }
    }

    return 0;
}