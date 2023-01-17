package eu.pp.test.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.pp.test.exception.ConfigurationException;
import eu.pp.test.exception.TestWSException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.SOAPMessage;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Util {

        public static String APPLICATION_NAME = "TESTWS";

        private static final String DATE_SIMPLE_PATTERN = "yyyy-MM-dd";
        private static final String DATE_SIMPLE_PL_PATTERN = "dd-MM-yyyy";
        private static final String DATE_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss";
        private static final String DATE_SESCM_PATTERN = "yyMMdd";
        private static final String TIME_SIMPLE_PATTERN = "HH:mm:ss";
        private static final String TIME_WITH_MILISECONDS_PATTERN = "HH:mm:ss:SSS";
        private static final String DATE_TIME_ID_PATTERN = "yyyyMMddHHmmssSSS";

        public static final String PARAMETERS_SEPARATOR = "/";
        public static final String PARAMETERS_VALUE_SEPARATOR = "=";

        public final static String VERSION_FORMAT = "^(?:(\\d+)\\.)?(?:(\\d+)\\.)?(\\*|\\d+)$";

        public static final String NEW_LINE = "\r\n";

        private static ObjectMapper mObjectMapper = new ObjectMapper();

        public static XMLGregorianCalendar getXMLGregorianCalendar(Date date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            String dateStr = sdf.format(date);
            GregorianCalendar gCalendar = new GregorianCalendar();
            try {
                gCalendar.setTime(sdf.parse(dateStr));
            } catch( NullPointerException npe ) {

            } catch (ParseException e) {
            }
            XMLGregorianCalendar xmlCalendar = null;
            try {
                xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
                xmlCalendar.setTimezone( DatatypeConstants.FIELD_UNDEFINED );
                xmlCalendar.setMillisecond( DatatypeConstants.FIELD_UNDEFINED );
            } catch (DatatypeConfigurationException ex) {

            }
            return xmlCalendar;
        }

        public static Date getDate(XMLGregorianCalendar calendar) {
            if (calendar == null) {
                return null;
            }
//        GregorianCalendar t = calendar.toGregorianCalendar();
            return calendar.toGregorianCalendar().getTime();
        }

        public static String getDate(Date data) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_SIMPLE_PATTERN);
            return sdf.format(data);
        }

        public static String getPLDate(Date data) {
            if( data == null ) return "";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_SIMPLE_PL_PATTERN);
            return sdf.format(data);
        }

        public static String getSESCMDate(Date data) {
            if( data == null ) return "";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_SESCM_PATTERN );
            return sdf.format(data);
        }

        public static String getTime(Date data) {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_SIMPLE_PATTERN);
            return sdf.format(data);
        }

        public static String getTimeMS(Date data) {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_WITH_MILISECONDS_PATTERN);
            return sdf.format(data);
        }

        public static Date getDate(String data) {
            if( data == null ) return null;
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_SIMPLE_PATTERN);
            try {
                return sdf.parse(data);
            } catch( NullPointerException npe ) {
            } catch (ParseException e) {
            }
            return null;
        }

        public static Date getPLDate(String data) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_SIMPLE_PL_PATTERN);
            try {
                return sdf.parse(data);
            } catch( NullPointerException npe ) {
            } catch (ParseException e) {
            }
            return null;
        }

        public static Date getSESCMDate(String data) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_SESCM_PATTERN);
            try {
                return sdf.parse(data);
            } catch( NullPointerException npe ) {
            } catch (ParseException e) {
            }
            return null;
        }

        public static Date getCurrentDate() {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_SIMPLE_PATTERN);
            return getDate(sdf.format(new Date()));
        }

        public static String getCurrentStringDate() {
            return getDate(new Date());
        }

        public static Date now() {
            return new Date();
        }

        public static Date getTime(String data) {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_SIMPLE_PATTERN);
            try {
                return sdf.parse(data);
            } catch( NullPointerException npe ) {
            } catch (ParseException e) {
            }
            return null;
        }

        public static Date getTimeMS(String data) {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_WITH_MILISECONDS_PATTERN);
            try {
                return sdf.parse(data);
            } catch( NullPointerException npe ) {
            } catch (ParseException e) {
            }
            return null;
        }

        public static String getFullDate(Date date) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FULL_PATTERN);
            return sdf.format(date);
        }

        public static Date trimDate(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);

            return calendar.getTime();
        }

        public static String getUniqueDateTimeID(Date data) {
            SimpleDateFormat sdf = new SimpleDateFormat( DATE_TIME_ID_PATTERN );
            return sdf.format(data);
        }

        // nullsafe string comparision
        public static boolean equalsCIS(String str1, String str2) {
            if (str1 == null || str2 == null) {
                return false;
            }
            return str1.equalsIgnoreCase(str2);
        }

        // nullsafe string comparision
        public static boolean equals(String str1, String str2) {
            if (str1 == null || str2 == null) {
                return false;
            }
            return str1.equals(str2);
        }

        public static BigDecimal getBigDecimal(double val, int scale) {
            return new BigDecimal(String.valueOf(val)).setScale(scale, RoundingMode.HALF_UP);
        }

        public static String soapMessageToString(SOAPMessage message) {
            String result = null;

            if (message != null) {
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    message.writeTo(baos);
                    result = baos.toString();
                } catch (Exception e) {
                }
            }
            return result;
        }

        public static String createUniqueId(long operationId) {
            Date d = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            SimpleDateFormat formatter2 = new SimpleDateFormat("S");
            String formattedDate = formatter.format(d);
            String idStr;
            if (operationId == 0) {
                idStr = formatter2.format(d);
            } else {
                idStr = String.valueOf(operationId);
            }
            String uniqueId;
            if (idStr.length() > 10) {
                uniqueId = idStr.substring(idStr.length() - 10);
            } else {
                uniqueId = idStr;
            }
            return "WS" + formattedDate + String.format("%10s", uniqueId).replace(" ", "0");
        }

//        // sprawdza czy pomiedzy data1 (nowsza) a data2 (starsza) nie ma wiecej niz validityPeriod, jeĹ›li jest mniej - zwraca true - data ok, wpp zwraca false - data nie ok = zbyt stara
//        public static boolean isDateValid(Date date2check, Date dateRef, Period validityPeriod) throws TimeCompareException {
//            logger.info("isDateValid * date2check: " + getFullDate(date2check) + ", dateRef: " + getFullDate(dateRef) + ", period: " + validityPeriod.toString());
//            if (validityPeriod.getUnit() == TimeUnit.Y || validityPeriod.getUnit() == TimeUnit.MO) {
//                throw new TimeCompareException("Nie moĹĽna okreĹ›liÄ‡ dokĹ‚adnej dĹ‚ugoĹ›ci okresu dla jednostki: " + validityPeriod.getUnit().getNamePL());
//            }
//            long diff = date2check.getTime() - dateRef.getTime();
//            return diff <= 1L * validityPeriod.getNumber() * validityPeriod.getUnit().getSeconds() * 1000;
//        }ConfigurationException


        /* 1 - v1 > v2
           0 - v1 == v2
          -1 - v1 < v2
         */
        public static int compareVersions(String v1, String v2) throws ConfigurationException {
            if (!v1.matches(VERSION_FORMAT)) {
                throw new ConfigurationException("Version number format error: " + v1);
            }
            if (!v2.matches(VERSION_FORMAT)) {
                throw new ConfigurationException("Version number format error: " + v2);
            }
            //if( v1.equals( "0.0.33" ) ) throw new ConfigurationException( "Trick" );
            if (v1.equals(v2)) {
                return 0;
            }
            String[] vT1, vT2;
            vT1 = v1.split("\\.");
            vT2 = v2.split("\\.");
            int n1;
            int n2;
            int i = 0;
            while (i < Math.max(vT1.length, vT2.length)) {
                try {
                    n1 = Integer.parseInt(vT1[i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    n1 = 0;
                }
                try {
                    n2 = Integer.parseInt(vT2[i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    n2 = 0;
                }
                if (n1 > n2) {
                    return 1;
                }
                if (n2 > n1) {
                    return -1;
                }
                i++;
            }
            return 0;
        }

        public static boolean isVersionNewer(String v1, String v2) throws ConfigurationException {
            return compareVersions(v1, v2) > 0;
        }

        public static boolean isOlder(String v1, String v2) throws ConfigurationException {
            return compareVersions(v1, v2) < 0;
        }

        public static String getJson(Object o) throws JsonProcessingException {
            if (mObjectMapper == null) {
                mObjectMapper = new ObjectMapper();
            }
//            try {
                return mObjectMapper.writeValueAsString(o);
//            } catch (JsonProcessingException e) {
//                throw e;
//            }
        }

        public static boolean validateJson(String json) {
            try {
                mObjectMapper.readTree(json);
                return true;
            } catch (JsonProcessingException je) {
            } catch ( IOException ioe ) {
            } catch ( Exception e ) {
            }
            return false;
        }

        public static <T> T getObjectFromJson( String jsonStr, Class<T> objectType ) {
            try {
                return (T) mObjectMapper.readValue( jsonStr, objectType );
            } catch (JsonProcessingException je) {
            } catch ( IOException ioe ) {
            } catch ( Exception e ) {
            }
            return null;
        }

        public static <T> List<T> safeList(List<T> other) {
            return other == null ? Collections.<T>emptyList() : other;
        }

        public static <T> Set<T> safeSet(Set<T> other) {
            return other == null ? Collections.<T>emptySet(): other;
        }

        public static <T> boolean tabContainsObject(T[] tab, T obj ) {
            if( tab == null ) return false;
            for (T t : tab) if (t.equals(obj)) return true;
//        for( int i=0; i<tab.length; i++ ) if( tab[i].equals( obj ) ) return true;
            return false;
        }

        public static <T> String list2String( List<T> list ) {
            return list2String( list, ", " );
        }

        public static <T> String list2String( List<T> list, String sep ) {
            StringBuilder bld = new StringBuilder();
            int i=0;
            for( T o: safeList( list ) ) {
                bld.append( o.toString() );
                if( ++i < list.size() ) bld.append( sep );
            }
            return bld.toString();
        }

        public static boolean checkError( Exception e, String dbConstraintName ) {
            try {
                if( e == null || dbConstraintName == null || e.getMessage() == null ) return false;
                if( e.getMessage().contains(dbConstraintName) ) return true;
            } catch( Exception ex ) {
                return false;
            }
            return false;
        }

        public static String removeLeadingZeros( String txt ) {
            return (txt==null?"":txt.replaceAll("^0*", ""));
        }

        public static byte[] zipString2ByteTableWithFileName(String str, String fileName ) {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zos = new ZipOutputStream(bos);

            try {
                zos.putNextEntry( new ZipEntry( fileName + ".json" ) );
                zos.write( str.getBytes() );
                zos.flush();
                zos.finish();
            } catch (Exception ex) {
            }

            return bos.toByteArray();
        }

        public static String unzipByteTable2StringWithFileName( byte[] data, String fileName ) {

            ByteArrayInputStream bis = new ByteArrayInputStream( data );
            ZipInputStream zis = new ZipInputStream( bis );
            ZipEntry ze;
            int BUFFER_SIZE = 1024;
            byte[] buffer = new byte[BUFFER_SIZE];
            StringBuilder strBld = new StringBuilder();

            try {
                ze = zis.getNextEntry();
                //logger.info("ZipEntry: " + ze.getName() + " size: " + ze.getSize() );
                int len;
                while ((len = zis.read(buffer, 0, BUFFER_SIZE)) > 0) {
                    strBld.append( new String( buffer, 0, len ) );
                }
                //logger.info("Data: " + strBld.toString() );
                zis.close();
                bis.close();
            } catch (Exception ex) {
            }

            return strBld.toString();
        }

        public static String getHost() {
            try {
                InetAddress addr = InetAddress.getLocalHost();
                return addr.getHostName();
            } catch ( Exception e ) {
                return null;
            }
        }


        public static Map<String, String> parseParameters(String parametersString, boolean logParameters ) {
            Map<String, String> parametersMap = new HashMap<>();
            String[] paramsTab;
            String[] pTab;
            String str;
            try{
                parametersString = parametersString.replace( " " + PARAMETERS_SEPARATOR + " ", PARAMETERS_SEPARATOR );
                parametersString = parametersString.replace( PARAMETERS_SEPARATOR + " ", PARAMETERS_SEPARATOR );
                parametersString = parametersString.replace( " " + PARAMETERS_SEPARATOR, PARAMETERS_SEPARATOR );
                paramsTab = parametersString.split( PARAMETERS_SEPARATOR );

                for( String p: paramsTab ) {
                    str = p.replace( " " + PARAMETERS_VALUE_SEPARATOR + " ", PARAMETERS_VALUE_SEPARATOR );
                    str = str.replace( PARAMETERS_VALUE_SEPARATOR + " ", PARAMETERS_VALUE_SEPARATOR );
                    str = str.replace( " " + PARAMETERS_VALUE_SEPARATOR, PARAMETERS_VALUE_SEPARATOR );
                    pTab = str.split( PARAMETERS_VALUE_SEPARATOR );
                    if( pTab.length == 2 )
                        parametersMap.put( pTab[0], pTab[1] );
                }
                if( logParameters ) {
                    for (String k : parametersMap.keySet()) {
//                        logger.error(k + " = " + parametersMap.get(k));
                    }
                }
            }catch ( Exception e ) {
//                logger.error("parseParameters - parsing error for: " + parametersString , e );
            }
            return parametersMap;
        }

        public static String createParametersString( Map<String, String> parametersMap ) {
            if( parametersMap == null ) return "";
            StringBuilder stringBuilder = new StringBuilder();
            int cnt = 0;
            for( String k: parametersMap.keySet() ) {
                if( cnt++ != 0 ) {
                    stringBuilder.append( " " )
                            .append( PARAMETERS_SEPARATOR )
                            .append( " " );
                }
                stringBuilder.append( k )
                        .append( " " )
                        .append( PARAMETERS_VALUE_SEPARATOR )
                        .append( " " )
                        .append( parametersMap.get( k ) );
            }
            return stringBuilder.toString();
        }

        public static boolean inList( String value, String... list ) {
            if( value == null || list == null || list.length == 0 ) return false;
//            return Stream.of( list ).anyMatch( value::equals );
            return Arrays.asList( list ).contains( value );

//            return Stream.of( list ).anyMatch( value::equals );
        }

        public static boolean inListIgnoreCase( String value, String... list ) {
            if( value == null || list == null || list.length == 0 ) return false;
            return Stream.of( list ).anyMatch( value::equalsIgnoreCase );
        }

        public static String stringConcatenate(List<String> stringsList ) {
            return stringConcatenate( stringsList, null );
        }

        public static String stringConcatenate(List<String> stringsList, String separator ) {
            if( stringsList == null || stringsList.size() == 0 ) return null;
            StringBuilder strBld = new StringBuilder();
            boolean first = true;
            for( String s: safeList( stringsList ) ) {
                if( !first && separator != null ) strBld.append( separator );
                strBld.append( s );
                if( first ) first = false;
            }
            return strBld.toString();
        }

        public static void throwAppSException( int code, String text ) throws TestWSException {
            throwAppSException( code, text, null );
        }

        public static void throwAppSException( int code, String text, Exception e ) throws TestWSException {
            throw logAppException( code, text, e );
        }

        public static TestWSException logAppException( int code, String text ) {
            return logAppException( code, text, null );
        }

        public static TestWSException logAppException( int code, String text, Exception e ) {
            TestWSException appException = new TestWSException( code, text );
            if( e != null )
//                logger.error( appException.toString(), e );
                ;
            else
//                logger.error( appException.toString() );
            ;
            return appException;
        }

         public static Properties readPropertiesFromFile( ClassLoader classLoader, String fileName ) throws TestWSException {
            Properties props = new Properties();
            try {
                InputStream in = classLoader.getResourceAsStream(fileName);
                if (in == null) {
                    in = classLoader.getResourceAsStream(fileName);
                }

                if (in == null) throwAppSException(-1, "File not found: " + fileName);

                try {
                    props.load((InputStream)in);
                } catch (IOException ioe) {
                    throwAppSException(-2, "IO Exception while reading file: " + fileName);
                }
                return props;
            }catch ( TestWSException twse ) {
                throw twse;
            }catch ( Exception e ) {
                throwAppSException( -3, "Unhandled exception for file: " + fileName, e );
            }
            return null;
        }



}
