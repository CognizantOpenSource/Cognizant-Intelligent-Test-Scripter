package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{ECCB1143-8914-497A-ACA0-8789CA64C2D6}")
public abstract interface IGraph
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String colName(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract String rowName(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  public abstract short colType(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract int data(int paramInt1, int paramInt2);
  
  @DISPID(5)
  @VTID(11)
  public abstract int colCount();
  
  @DISPID(6)
  @VTID(12)
  public abstract int rowCount();
  
  @DISPID(7)
  @VTID(13)
  public abstract IList drillDown(@MarshalAs(NativeType.VARIANT) Object paramObject1, @MarshalAs(NativeType.VARIANT) Object paramObject2);
  
  @DISPID(8)
  @VTID(14)
  public abstract int maxValue();
  
  @DISPID(9)
  @VTID(15)
  public abstract int graphTotal();
  
  @DISPID(10)
  @VTID(16)
  public abstract int rowTotal(int paramInt);
  
  @DISPID(11)
  @VTID(17)
  public abstract int colTotal(int paramInt);
  
  @DISPID(12)
  @VTID(18)
  public abstract IList multiDrillDown(@MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(13)
  @VTID(19)
  public abstract Date startDate();
  
  @DISPID(14)
  @VTID(20)
  public abstract IList warnings();
  
  @VTID(20)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object warnings(int paramInt);
  
  @DISPID(15)
  @VTID(21)
  public abstract IList crossDrillDown(@MarshalAs(NativeType.VARIANT) Object paramObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IGraph
 * JD-Core Version:    0.7.0.1
 */