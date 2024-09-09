#include <iostream>

int main() {
    std::cout << std::fixed;
    std::cout.precision(6);

    int weight = 13;
    double gravity = 0.165;

    std::cout << weight << " * " << gravity << " = " << weight * gravity;
    
    return 0;
}