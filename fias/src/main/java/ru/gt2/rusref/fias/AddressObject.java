package ru.gt2.rusref.fias;

import lombok.ToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;
import java.util.UUID;

/**
 * Классификатор адресообразующих элементов.
 * Вместо Object сделали AddressObject, т.к. в Java один Object уже есть, чтобы не было путаницы.
 * Да и положено так, чтобы внутри AddressObjects были именно AddressObject'ы, а не просто Object'ы.
 *
 * @author rage
 */
@ToString
public class AddressObject {

    /** Глобальный уникальный идентификатор адресного объекта. */
    @NotNull
    @Size(min = 36, max = 36)
    @XmlAttribute(name = "AOGUID", required = true)
    private UUID aoGuid;

    /** Формализованное наименование. */
    @NotNull
    @Size(min = 1, max = 120)
    @XmlAttribute(name = "FORMALNAME", required = true)
    private String formalName;

    /** Код региона. */
    @NotNull
    @Size(min = 2, max = 2)
    @XmlAttribute(name = "REGIONCODE", required = true)
    private String regionCode;

    /** Код автономии. */
    @NotNull
    @Size(min = 1, max = 1)
    @XmlAttribute(name = "AUTOCODE", required = true)
    private String autoCode;

    /** Код района. */
    @NotNull
    @Size(min = 3, max = 3)
    @XmlAttribute(name = "AREACODE", required = true)
    private String areaCode;

    /** Код города. */
    @NotNull
    @Size(min = 3, max = 3)
    @XmlAttribute(name = "CITYCODE", required = true)
    private String cityCode;

    /** Код внутригородского района. */
    @NotNull
    @Size(min = 3, max = 3)
    @XmlAttribute(name = "CTARCODE", required = true)
    private String ctarCode;

    /** Код насленного пункта. */
    @NotNull
    @Size(min = 3, max = 3)
    @XmlAttribute(name = "PLACECODE", required = true)
    private String placeCode;

    /** Код улицы. */
    @Size(min = 4, max = 4)
    @XmlAttribute(name = "STREETCODE")
    private String streetCode;

    /** Код дополнительного адресообразующего элемента. */
    @NotNull
    @Size(min = 4, max = 4)
    @XmlAttribute(name = "EXTRCODE", required = true)
    private String extrCode;

    /** Код подчиненного дополнительного адресообразующего элемента. */
    @NotNull
    @Size(min = 4, max = 4)
    @XmlAttribute(name = "SEXTCODE", required = true)
    private String sextCode;

    /** Официальное наименование. */
    @Size(min = 1, max = 120)
    @XmlAttribute(name = "OFFNAME")
    private String offName;

    /** Почтовый индекс. */
    @Size(min = 6, max = 6)
    @XmlAttribute(name = "POSTALCODE")
    private String postalCode;
    
    /** Код ИФНС ФЛ. */
    @Size(min = 4, max = 4)
    @XmlAttribute(name = "IFNSFL")
    private String ifnsFl;

    /** Код территориального участка ИФНС ФЛ. */
    @Size(min = 4, max = 4)
    @XmlAttribute(name = "TERRIFNSFL")
    private String terrIfnsFl;

    /** Код ИФНС ЮЛ. */
    @Size(min = 4, max = 4)
    @XmlAttribute(name = "IFNSUL")
    private String ifnsUl;

    /** Код территориального участка ИФНС ЮЛ. */
    @Size(min = 4, max = 4)
    @XmlAttribute(name = "TERRIFNSUL")
    private String terrIfnsUl;
    
    /** ОКАТО. */
    @Size(min = 11, max = 11)
    @XmlAttribute(name = "OKATO")
    private String okato;

    /** ОКТМО. */
    @Size(min = 8, max = 8)
    @XmlAttribute(name = "OKATO")
    private String oktmo;

    /** Дата внесения записи. */
    @NotNull
    @Past
    @XmlAttribute(name = "UPDATEDATE", required = true)
    private Date updateDate;

    /** Краткое наименование типа объекта. */
    @NotNull
    @Size(min = 1, max = 10)
    @XmlAttribute(name = "SHORTNAME", required = true)
    private String shortName;

    /** Уровень адресного объекта */
    @NotNull
    @Digits(integer = 10, fraction = 0)
    @XmlAttribute(name = "AOLEVEL", required = true)
    private Integer aoLevel;

    /** Идентификатор объекта родительского объекта. */
    @XmlAttribute(name = "PARENTGUID")
    private UUID parentGuid;

    /** Уникальный идентификатор записи. Ключевое поле. */
    @NotNull
    @XmlAttribute(name = "AOID", required = true)
    private UUID aoId;

    /** Идентификатор записи связывания с предыдушей исторической записью. */
    @XmlAttribute(name = "PREVID")
    private UUID prevId;

    /** Идентификатор записи  связывания с последующей исторической записью. */
    @XmlAttribute(name = "NEXTID")
    private UUID nextId;

    /** Код адресного объекта одной строкой с признаком актуальности из КЛАДР 4.0. */
    @Size(min = 17, max = 17)
    @XmlAttribute(name = "CODE")
    private String code;

    /** Код адресного объекта из КЛАДР 4.0 одной строкой без признака актуальности (последних двух цифр). */
    @Size(min = 15, max = 15)
    @XmlAttribute(name = "PLAINCODE")
    private String plainCode;

    /**
     * Статус актуальности адресного объекта ФИАС.
     * Актуальный адрес на текущую дату.
     * Обычно последняя запись об адресном объекте.
     */
    @NotNull
    @Digits(integer = 10, fraction = 0)
    @XmlAttribute(name = "ACTSTATUS", required = true)
    private Integer actStatus;

    /** Статус центра. */
    @NotNull
    @Digits(integer = 10, fraction = 0)
    @XmlAttribute(name = "CENTSTATUS", required = true)
    private Integer centStatus;

    /**
     * Статус действия над записью – причина появления записи.
     * (см. описание таблицы OperationStatus)
     */
    @NotNull
    @Digits(integer = 10, fraction = 0)
    @XmlAttribute(name = "OPERSTATUS", required = true)
    private Integer operStatus;

    /** Статус актуальности КЛАДР 4 (последние две цифры в коде). */
    @NotNull
    @Digits(integer = 10, fraction = 0)
    @XmlAttribute(name = "CURRSTATUS", required = true)
    private Integer currStatus;

    /** Начало действия записи. */
    @NotNull
    @XmlAttribute(name = "STARTDATE", required = true)
    private Date startDate;

    /** Окончание действия записи. */
    @NotNull
    @XmlAttribute(name = "ENDDATE", required = true)
    private Date endDate;
    
    /** Внешний ключ на нормативный документ. */
    @Size(min = 36, max = 36)
    @XmlAttribute(name = "NORMDOC")
    private UUID normDoc;

}
