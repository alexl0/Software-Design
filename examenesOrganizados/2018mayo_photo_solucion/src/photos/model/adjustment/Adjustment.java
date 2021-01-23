package photos.model.adjustment;

public abstract interface Adjustment
{
  public abstract String getName();
  
  public abstract int getValue();
  
  public abstract Adjustment setValue(int paramInt);
  
  public abstract String apply(String paramString);
  
  public abstract Adjustment duplicate();
}


/* Location:              C:\Users\jandr\Desktop\photos.jar!\photos\model\adjustment\Adjustment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */