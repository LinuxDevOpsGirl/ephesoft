/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.da.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ephesoft.dcma.da.constant.DataAccessConstant;
import com.ephesoft.dcma.da.dao.FieldTypeDao;
import com.ephesoft.dcma.da.domain.DocumentType;
import com.ephesoft.dcma.da.domain.FieldType;

/**
 * This is a database service to read data required by Field Type Service .
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.da.service.FieldTypeService
 */
@Service("fieldTypeService")
public class FieldTypeServiceImpl implements FieldTypeService {

	/**
	 * LOGGER to print the logging information.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FieldTypeServiceImpl.class);

	/**
	 * fieldTypeDao {@link FieldTypeDao}.
	 */
	@Autowired
	private FieldTypeDao fieldTypeDao;

	/**
	 * An API to fetch all Field types by document type name.
	 * 
	 * @param docTypeName {@link String}
	 * @param batchInstanceIdentifier {@link String}
	 * @return List<{@link FieldType}>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<FieldType> getFdTypeByDocTypeNameForBatchInstance(String docTypeName, String batchInstanceIdentifier) {
		List<FieldType> fdTypes = null;
		if (null == docTypeName || DataAccessConstant.EMPTY.equals(docTypeName)) {
			LOGGER.info(DataAccessConstant.DOCUMENT_TYPE_NAME_IS_NULL_OR_EMPTY);
		} else {
			fdTypes = fieldTypeDao.getFdTypeByDocTypeNameForBatchInstance(docTypeName, batchInstanceIdentifier);
		}
		return fdTypes;
	}

	/**
	 * An API to fetch Field types by document type name.
	 * 
	 * @param fieldTypeName {@link String}
	 * @param docTypeName  {@link String}
	 * @param batchInstanceIdentifier   {@link String}
	 * @return FieldType {@link FieldType}
	 */
	@Transactional(readOnly = true)
	@Override
	public FieldType getFieldType(String fieldTypeName, String docTypeName, String batchInstanceIdentifier) {
		FieldType fdTypes = null;
		if (null == docTypeName || DataAccessConstant.EMPTY.equals(docTypeName)) {
			LOGGER.info(DataAccessConstant.DOCUMENT_TYPE_NAME_IS_NULL_OR_EMPTY);
		} else {
			fdTypes = fieldTypeDao.getFieldType(fieldTypeName, docTypeName, batchInstanceIdentifier);
		}
		return fdTypes;
	}

	/**
	 * An API to fetch all Field types by document type name.
	 * 
	 * @param docTypeName {@link String}
	 * @param batchInstanceIdentifier {@link String}
	 * @return List<{@link FieldType}>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<FieldType> getFdTypeByDocTypeName(String docTypeName, String batchInstanceIdentifier) {
		List<FieldType> fdTypes = null;
		if (null == docTypeName || DataAccessConstant.EMPTY.equals(docTypeName)) {
			LOGGER.info(DataAccessConstant.DOCUMENT_TYPE_NAME_IS_NULL_OR_EMPTY);
		} else {
			fdTypes = fieldTypeDao.getFdTypeByDocumentTypeName(docTypeName, batchInstanceIdentifier, false);
		}
		return fdTypes;
	}

	/**
	 * An API to fetch all Field types and KV Extraction by document type name.
	 * 
	 * @param docTypeName {@link String}
	 * @param batchInstanceIdentifier {@link String}
	 * @param isKVExtraction boolean
	 * @return List<{@link FieldType}>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<FieldType> getFdTypeAndKVExtractionByDocTypeName(String docTypeName, String batchInstanceIdentifier,
			boolean isKVExtraction) {
		List<FieldType> fdTypes = null;
		if (null == docTypeName || DataAccessConstant.EMPTY.equals(docTypeName)) {
			LOGGER.info(DataAccessConstant.DOCUMENT_TYPE_NAME_IS_NULL_OR_EMPTY);
		} else {
			fdTypes = fieldTypeDao.getFdTypeByDocumentTypeName(docTypeName, batchInstanceIdentifier, isKVExtraction);
		}
		return fdTypes;
	}

	/**
	 * An API to fetch all Field types and Regex Validation type name.
	 * 
	 * @param docTypeName {@link String}
	 * @param batchInstanceIdentifier {@link String}
	 * @return List<{@link FieldType}>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<FieldType> getFdTypeAndRegexValidationByDocTypeName(String docTypeName, String batchInstanceIdentifier) {
		List<FieldType> fdTypes = null;
		if (null == docTypeName || DataAccessConstant.EMPTY.equals(docTypeName)) {
			LOGGER.info(DataAccessConstant.DOCUMENT_TYPE_NAME_IS_NULL_OR_EMPTY);
		} else {
			fdTypes = fieldTypeDao.getFdTypeAndRegexValidationByDocTypeName(docTypeName, batchInstanceIdentifier);
		}
		return fdTypes;

	}

	/**
	 * An API to fetch all Field types by document type.
	 * 
	 * @param documentType {@link DocumentType}
	 * @return List<FieldType>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<FieldType> getFdTypeByDocumentType(DocumentType documentType) {
		List<FieldType> fdTypes = null;
		if (null == documentType) {
			LOGGER.info("Document type object is null.");
		} else {
			fdTypes = fieldTypeDao.getFdTypeByDocumentType(documentType);
		}
		return fdTypes;
	}

	/**
	 * An API to insert the fieldType object.
	 * 
	 * @param fieldType {@link FieldType}
	 */
	@Transactional
	@Override
	public void insertFieldType(FieldType fieldType) {
		if (null == fieldType) {
			LOGGER.info("FieldType object is null.");
		} else {
			fieldTypeDao.insertFieldType(fieldType);
		}
	}

	/**
	 * An API to update the fieldType object.
	 * 
	 * @param fieldType {@link FieldType}
	 */
	@Transactional
	@Override
	public void updateFieldType(FieldType fieldType) {
		if (null == fieldType) {
			LOGGER.info("FieldType object is null.");
		} else {
			fieldTypeDao.updateFieldType(fieldType);
		}
	}

	/**
	 * An API to remove the fieldType object.
	 * 
	 * @param fieldType {@link FieldType}
	 */
	@Transactional
	@Override
	public void removeFieldType(FieldType fieldType) {
		if (null == fieldType) {
			LOGGER.info("FieldType object is null.");
		} else {
			fieldTypeDao.removeFieldType(fieldType);
		}
	}

	/**
	 * An API to fetch all Field types by document type name for batch class.
	 * 
	 * @param docTypeName {@link String}
	 * @param batchClassIdentifier {@link String}
	 * @return List<{@link FieldType}>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<FieldType> getFdTypeByDocTypeNameForBatchClass(String docTypeName, String batchClassIdentifier) {
		List<FieldType> fdTypes = null;
		fdTypes = fieldTypeDao.getFdTypeByDocumentTypeNameForBatchClass(docTypeName, batchClassIdentifier);
		return fdTypes;
	}
}
