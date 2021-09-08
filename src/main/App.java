package main;

public class App
{
    public static void main(String[] args) 
    {
        System.out.println(buildCommandPod(4));
    }
    static String buildCommandPod(int size)
    {
        var width = size * 4;
        var midAssembly = "*".repeat(size-1);

        var commandAssembly = new StringBuilder();

        for (int i = 0; i != size+2; ++i)
        {
            int x = 2;
            for (int j = 0; j < (size+2) - (i + 1); ++j)
            {
                commandAssembly.append(" ");
            }
            for (int j = 0; j < i + 1; ++j)
            {
                commandAssembly.append("/");
            }
            commandAssembly.append(midAssembly);
            for (int j = 0; j < i + 1; ++j)
            {
                commandAssembly.append("\\");
            }
            for (int j = 0; j < 5 - (i + 1); ++j)
            {
                commandAssembly.append(" ");
            }
            commandAssembly.append('\n');
        }

        return commandAssembly.toString();
    }
    static String buildSection(int size)
    {
        return null;
    }
    static String buildSectionReverse(int size)
    {
        return null;
    }
    static String buildSectionSeperator(int size)
    {
        return null;
    }
    static String buildRocket(int size)
    {
        var rocketAssembly = new StringBuilder();
        rocketAssembly.append(buildCommandPod(size));
        
        return null;
    }
}
