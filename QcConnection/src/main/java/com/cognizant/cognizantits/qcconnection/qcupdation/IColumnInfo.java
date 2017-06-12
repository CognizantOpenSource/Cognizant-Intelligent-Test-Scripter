package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{0993EF6D-FAF3-42FF-BCF9-85BBB83753F6}")
public abstract interface IColumnInfo
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int colCount();
  
  @DISPID(2)
  @VTID(8)
  public abstract int colSize(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  public abstract int colType(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract String colName(int paramInt);
  
  @DISPID(5)
  @VTID(11)
  public abstract int colIndex(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IColumnInfo
 * JD-Core Version:    0.7.0.1
 */