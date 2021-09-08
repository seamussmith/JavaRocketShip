package gov.nasa.rocketbuildingtools;

import java.util.Arrays;

public class VehicleAssemblyBay {
    static String buildCommandPod(int size)
    {
        // Only increase width of mid section every even size
        var midAssembly = "*".repeat(size-(size%2));

        var commandAssembly = new StringBuilder();

        // Only add one to the height of the pod every odd number
        var sizeAddition = size/2 + (size%2);

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
            commandAssembly.append(midAssembly);
            for (int j = 0; j <= i; ++j)
            {
                commandAssembly.append("\\");
            }
            commandAssembly.append('\n');
        }

        return commandAssembly.toString();
    }
    static String buildFirstSectionHalf(int size)
    {
        var sectionAssembly = new StringBuilder();
        for (int i = size; i > 0; --i)
        {
            sectionAssembly.append("|");
            for (int j = 0; j < size + (size - i); ++j)
            {
                sectionAssembly.append(".");
            }
            for (int j = 0; j < size + (i - size); ++j)
            {
                sectionAssembly.append("\\/");
            }
            for (int j = 0; j < size + (size - i); ++j)
            {
                sectionAssembly.append(".");
            }
            sectionAssembly.append("|\n");
        }
        return sectionAssembly.toString();
    }
    
    static String buildSecondSectionHalf(int size)
    {
        var sectionAssembly = new StringBuilder();
        for (int i = 1; i <= size; ++i)
        {
            sectionAssembly.append("|");
            for (int j = 0; j < size + (size - i); ++j)
            {
                sectionAssembly.append(".");
            }
            for (int j = 0; j < size + (i - size); ++j)
            {
                sectionAssembly.append("/\\");
            }
            for (int j = 0; j < size + (size - i); ++j)
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
        for (int i = 1; i <= width-2; ++i)
        {
            if (i % 2 == 0)
                seperatorAssembly.append("*");
            else
                seperatorAssembly.append("=");
        }
        seperatorAssembly.append("+\n");
        return seperatorAssembly.toString();
    }
    public static String buildRocket(int size)
    {
        var rocketAssembly = new StringBuilder();

        rocketAssembly.append(buildCommandPod(size));
        rocketAssembly.append(buildSectionSeperator(size));
        rocketAssembly.append(buildFirstSectionHalf(size));
        rocketAssembly.append(buildSecondSectionHalf(size));
        rocketAssembly.append(buildSectionSeperator(size));
        rocketAssembly.append(buildSecondSectionHalf(size));
        rocketAssembly.append(buildFirstSectionHalf(size));
        rocketAssembly.append(buildSectionSeperator(size));

        var spareCommandPod = buildCommandPod(size);

        var choppedPod = spareCommandPod.split("\n");

        var choppedBottom = Arrays.copyOfRange(choppedPod, 0, choppedPod.length-1);

        var definitelyNotACommandPodWorkshoppedIntoARocketEngine = String.join("\n", choppedBottom);

        rocketAssembly.append(definitelyNotACommandPodWorkshoppedIntoARocketEngine);
        return rocketAssembly.toString();
    }
}
