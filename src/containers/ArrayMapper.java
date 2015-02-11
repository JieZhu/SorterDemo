package containers;


public class ArrayMapper
{

  private static ArrayMapper instance = new ArrayMapper();

  private ArrayMapper()
  {
  }

  public static ArrayMapper Singleton()
  {
    return instance;
  }

  public void map(Object array[], ACommand aCommand)
  {
      for(int i=0; i<array.length;i++)
      {
        aCommand.execute(array[i]);
      }
  }

}