
// SPDX-License-Identifier: GPL-3.0


pragma solidity >=0.4.0 <0.9.0;

contract Calc {

    // uint public num1 = 10;
    // uint public num2 = 29;
    
    // // State variables can be used to store calculated values
    // uint public num3;

    // Event declaration
    event Printed(int result, int r2);

    // // Constructor to initialize num3
    // constructor() {
    //     num3 = num1 + num2;
    // }

    // Add function to add two unsigned integers and return an integer result
    function add(uint n1, uint n2) public pure returns (int) {
        return int(n1) + int(n2);
    }

    // Subtract function to subtract two unsigned integers and return an integer result
    function su(uint n1, uint n2) public pure returns (int) {
        return int(n1) - int(n2);
    }

    function mul (uint n1, uint n2) public pure returns (int) {return int(n1) * int(n2);}

    function div (uint n1, uint n2) public pure returns (int) {return int(n1)/ int (n2); }

    function mod (uint n1, uint n2) public pure returns (int) { return int(n1)% int(n2) ; }
}
