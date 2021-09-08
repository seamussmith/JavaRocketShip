package main;

import java.util.Scanner;

import gov.nasa.rocketbuildingtools.VehicleAssemblyBay;

public class App
{
    public static void main(String[] args) 
    {
        var scan = new Scanner(System.in);
        int s;

        while (true)
        {
            try
            {
                System.out.print("What size rocket do you want? > ");
                var input = scan.nextLine();
                s = Integer.parseInt(input);
                if (s <= 0)
                {
                    System.out.println("Please enter a number higher than zero");
                    continue;
                }
                break;
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid number");
            }
        }
        System.out.print(VehicleAssemblyBay.buildRocket(s));
        scan.close();
    }
}
