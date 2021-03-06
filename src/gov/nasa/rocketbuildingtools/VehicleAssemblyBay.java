package gov.nasa.rocketbuildingtools;

public class VehicleAssemblyBay
{
    public static String buildRocket(int size)
    {
        if (size <= 0)
            throw new IllegalArgumentException("Size cannot be less than 0. Given: " + size);
        // Rocket builder
        // (pretend it says new RocketBuilder())
        var rocketAssembly = new StringBuilder();
        
        // The Parts
        var sectionSeperator = buildSectionSeperator(size);
        var firstSectionHalf = buildFirstSectionHalf(size);
        var secondSectionHalf = buildSecondSectionHalf(size);
        var commandPod = buildCommandPod(size);

        // Command Pod
        rocketAssembly.append(commandPod);

        rocketAssembly.append(sectionSeperator);
        
        // First Fuelselage
        rocketAssembly.append(firstSectionHalf);
        rocketAssembly.append(secondSectionHalf);
        
        rocketAssembly.append(sectionSeperator);
        
        // Second Fuelselage
        rocketAssembly.append(secondSectionHalf);
        rocketAssembly.append(firstSectionHalf);
        
        rocketAssembly.append(sectionSeperator);

        // Attach the engine
        rocketAssembly.append(commandPod);

        // And we are good to go!
        return rocketAssembly.toString();
    }
    static String buildCommandPod(int size)
    {
        // Size bodgery with the command pod. Not the most fun thing to figure out...

        // Only increase width of mid section every even size
        // Each star adds one to the width
        // Did this because every even layer seemed to be one short
        var midAssembly = "*".repeat(size-(size%2));
        
        // Only add one to the height of the pod every odd number
        // Each layer adds two to the width
        // Did this because every odd layer seemed to be two short
        var sizeAddition = size/2 + (size%2);

        var commandAssembly = new StringBuilder();

        // Let us commence the command pod building!

        for (int i = 0; i != size+sizeAddition; ++i)
        {
            // Build the left side
            for (int j = 0; j < (size+sizeAddition) - i; ++j)
            {
                commandAssembly.append(" ");
            }
            for (int j = 0; j <= i; ++j)
            {
                commandAssembly.append("/");
            }
            // The middle part of the command pod
            commandAssembly.append(midAssembly);
            // The right side of the command pod
            for (int j = 0; j <= i; ++j)
            {
                commandAssembly.append("\\");
            }
            commandAssembly.append('\n');
        }

        return commandAssembly.toString();
    }
    static String buildSecondSectionHalf(int size)
    {
        var sectionAssembly = new StringBuilder();
        for (int i = size; i > 0; --i)
        {
            sectionAssembly.append("|");
            // Surface without arrow
            // Starts with (size) dots going up to (size * 2 - 1) dots
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            // Surface with arrow
            // Starts with (size * 2) arrows, going down to 1 arrow
            for (int j = 0; j < size + (i - size); ++j)
            {
                sectionAssembly.append("\\/");
            }
            // Surface without arrow
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            for (int j = 0; j < size + (i - size); ++j)
            {
                sectionAssembly.append("\\/");
            }
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            sectionAssembly.append("|\n");
        }
        return sectionAssembly.toString();
    }
    
    static String buildFirstSectionHalf(int size)
    {
        var sectionAssembly = new StringBuilder();
        for (int i = 1; i <= size; ++i)
        {
            // Wall
            sectionAssembly.append("|");
            // Surface without arrow
            // Starts with (size) dots going up to (size * 2 - 1) dots
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            // Surface with arrow
            // Starts with (size * 2) arrows, going down to 1 arrow
            for (int j = 0; j < size + (i - size); ++j)
            {
                sectionAssembly.append("/\\");
            }
            // Surface without arrow
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            for (int j = 0; j < size + (i - size); ++j)
            {
                sectionAssembly.append("/\\");
            }
            for (int j = 0; j < size - (i); ++j)
            {
                sectionAssembly.append(".");
            }
            sectionAssembly.append("|\n");
        }
        return sectionAssembly.toString();
    }
    static String buildSectionSeperator(int size)
    {
        var width = size * 4 + 2;
        var seperatorAssembly = new StringBuilder();
        seperatorAssembly.append("+");

        // The seperator
        for (int i = 1; i <= width-2; ++i)
        {
            // Every odd number is an "=" and every even number is a "*"
            if (i % 2 == 0)
                seperatorAssembly.append("*");
            else
                seperatorAssembly.append("=");
        }

        seperatorAssembly.append("+\n");
        return seperatorAssembly.toString();
    }
}
