package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{452897AD-D9F8-4EAE-80DB-B9C11807507F}")
public abstract interface ITDFilter
  extends Com4jObject
{
  @DISPID(12)
  @VTID(7)
  public abstract String _Text();
  
  @DISPID(12)
  @VTID(8)
  public abstract void _Text(String paramString);
  
  @DISPID(0)
  @VTID(9)
  @DefaultMethod
  public abstract String filter(String paramString);
  
  @DISPID(0)
  @VTID(10)
  @DefaultMethod
  public abstract void filter(String paramString1, String paramString2);
  
  @DISPID(1)
  @VTID(11)
  public abstract int order(String paramString);
  
  @DISPID(1)
  @VTID(12)
  public abstract void order(String paramString, int paramInt);
  
  @DISPID(2)
  @VTID(13)
  public abstract short orderDirection(String paramString);
  
  @DISPID(2)
  @VTID(14)
  public abstract void orderDirection(String paramString, short paramShort);
  
  @DISPID(3)
  @VTID(15)
  public abstract void clear();
  
  @DISPID(4)
  @VTID(16)
  public abstract IList newList();
  
  @VTID(16)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object newList(int paramInt);
  
  @DISPID(5)
  @VTID(17)
  public abstract IList fields();
  
  @VTID(17)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object fields(int paramInt);
  
  @DISPID(6)
  @VTID(18)
  public abstract void refresh();
  
  @DISPID(7)
  @VTID(19)
  public abstract boolean caseSensitive(String paramString);
  
  @DISPID(7)
  @VTID(20)
  public abstract void caseSensitive(String paramString, boolean paramBoolean);
  
  @DISPID(8)
  @VTID(21)
  public abstract String text();
  
  @DISPID(8)
  @VTID(22)
  public abstract void text(String paramString);
  
  @DISPID(9)
  @VTID(23)
  public abstract String xFilter(String paramString);
  
  @DISPID(9)
  @VTID(24)
  public abstract void xFilter(String paramString1, String paramString2);
  
  @DISPID(10)
  @VTID(25)
  public abstract String uFilter(String paramString);
  
  @DISPID(10)
  @VTID(26)
  public abstract void uFilter(String paramString1, String paramString2);
  
  @DISPID(11)
  @VTID(27)
  public abstract String dataType();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDFilter
 * JD-Core Version:    0.7.0.1
 */