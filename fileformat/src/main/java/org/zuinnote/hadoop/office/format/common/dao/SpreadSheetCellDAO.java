/**
* Copyright 2016 ZuInnoTe (Jörn Franke) <zuinnote@gmail.com>
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
**/

package org.zuinnote.hadoop.office.format.common.dao;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableFactories;
import org.apache.hadoop.io.Text;


/*
* This DAO represents a spreadsheet cell
*/

public class SpreadSheetCellDAO implements Writable, Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -1687737381474332741L;
private String formattedValue;
private String comment;
private String formula;
private String address;
private String sheetName;

public SpreadSheetCellDAO() {
	this.formattedValue="";
	this.comment="";
	this.formula="";
	this.address="";
	this.sheetName="";
	
}


public SpreadSheetCellDAO(String formattedValue, String comment, String formula, String address,String sheetName) {
	this.formattedValue=formattedValue;
	this.comment=comment;
	this.formula=formula;
	this.address=address;
	this.sheetName=sheetName;
}

public String getFormattedValue() {
	return this.formattedValue;
}

public String getComment() {
	return this.comment;
}

public String getFormula() {
	return this.formula;
}

public String getAddress() {
	return this.address;
}


public String getSheetName() {
	return this.sheetName;
}



public void set(SpreadSheetCellDAO newSpreadSheetCellDAO) {
	this.formattedValue=newSpreadSheetCellDAO.getFormattedValue();
        this.comment=newSpreadSheetCellDAO.getComment();
	this.formula=newSpreadSheetCellDAO.getFormula();
	this.address=newSpreadSheetCellDAO.getAddress();
	this.sheetName=newSpreadSheetCellDAO.getSheetName();
}


/** Writable **/

  @Override
  public void write(DataOutput dataOutput) throws IOException {
    Text formattedValueText = new Text("");
    if (formattedValue!=null) {
	formattedValueText = new Text(formattedValue);
    }
    Text commentText = new Text("");
    if (comment!=null) {
	commentText = new Text(comment);
    }
    Text formulaText = new Text("");
    if (formula!=null) {
	formulaText = new Text(formula);
    }
    Text addressText = new Text("");
    if (address!=null) {
	addressText = new Text(address);
    }
    Text sheetNameText = new Text("");
    if (sheetName!=null) {
	sheetNameText = new Text(sheetName);
    }
    formattedValueText.write(dataOutput);
    commentText.write(dataOutput);
    formulaText.write(dataOutput);
    addressText.write(dataOutput);
    sheetNameText.write(dataOutput);

}

  @Override
  public void readFields(DataInput dataInput) throws IOException {
    Text formattedValueText =  (Text) WritableFactories.newInstance(Text.class);
    formattedValueText.readFields(dataInput);
    this.formattedValue=formattedValueText.toString();
    Text commentText = (Text) WritableFactories.newInstance(Text.class);
    commentText.readFields(dataInput);
    this.comment=commentText.toString();
    Text formulaText = (Text) WritableFactories.newInstance(Text.class);
    formulaText.readFields(dataInput);
    this.formula=formulaText.toString();
    Text addressText = (Text) WritableFactories.newInstance(Text.class);
    addressText.readFields(dataInput);
    this.address=addressText.toString();
    Text sheetNameText = (Text) WritableFactories.newInstance(Text.class);
    sheetNameText.readFields(dataInput);
    this.sheetName=sheetNameText.toString();
}

}
