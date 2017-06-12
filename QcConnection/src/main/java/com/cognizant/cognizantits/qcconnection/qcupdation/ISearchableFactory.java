package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{03986C41-712B-4A6F-8C65-B50CBF7FC640}")
public abstract interface ISearchableFactory
  extends Com4jObject
{
  @DISPID(1001)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createSearchOptions();
  
  @DISPID(1002)
  @VTID(8)
  public abstract IList search(String paramString, @MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
  
  @DISPID(1003)
  @VTID(9)
  public abstract boolean isSearchable();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISearchableFactory
 * JD-Core Version:    0.7.0.1
 */