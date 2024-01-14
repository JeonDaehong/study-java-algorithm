import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DynamicQueryAlgorithm {

    private static String buildDynamicQuery(JSONObject mainJsonObject) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM TABLE WHERE ");

        if (mainJsonObject.containsKey("or")) {
            processConditions((JSONArray) mainJsonObject.get("or"), queryBuilder, " OR ");
        } else if (mainJsonObject.containsKey("and")) {
            processConditions((JSONArray) mainJsonObject.get("and"), queryBuilder, " AND ");
        }

        return queryBuilder.toString();
    }

    private static void processConditions(JSONArray conditionsArray, StringBuilder queryBuilder, String logicalOperator) {
        for (Object conditionObject : conditionsArray) {
            queryBuilder.append("(");
            JSONObject condition = (JSONObject) conditionObject;

            JSONArray subConditionsArray = null;
            if (condition.containsKey("or")) {
                subConditionsArray = (JSONArray) condition.get("or");
            } else if (condition.containsKey("and")) {
                subConditionsArray = (JSONArray) condition.get("and");
            }

            processSubConditions(subConditionsArray, queryBuilder);

            queryBuilder.append(")");
            queryBuilder.append(logicalOperator);
        }
        queryBuilder.delete(queryBuilder.length() - logicalOperator.length(), queryBuilder.length());
    }

    private static void processSubConditions(JSONArray subConditionsArray, StringBuilder queryBuilder) {
        if (subConditionsArray != null) {
            for (Object subConditionObject : subConditionsArray) {
                JSONObject subCondition = (JSONObject) subConditionObject;
                String field = (String) subCondition.get("field");
                String operator = (String) subCondition.get("operator");
                Object value = subCondition.get("value");
                queryBuilder.append(field).append(" ").append(operator).append(" ").append(value).append(" AND ");
            }
            queryBuilder.delete(queryBuilder.length() - 5, queryBuilder.length());
        }
    }


    // JSON 안에 condition 을 넣기 위해 만든 함수
    private static JSONObject createCondition(String field, String operator, Object value) {
        JSONObject condition = new JSONObject();
        condition.put("field", field);
        condition.put("operator", operator);
        condition.put("value", value);
        return condition;
    }
    
    public static void main(String[] args) {
        
        JSONObject mainJsonObject = new JSONObject();

        JSONArray orArray = new JSONArray();

        JSONArray andArray1 = new JSONArray();
        andArray1.add(createCondition("employmentDays", ">=", 1));
        andArray1.add(createCondition("employmentStartDate", ">=", "2022-01-01"));
        andArray1.add(createCondition("employmentEndDate", "<=", "2022-12-31"));
        andArray1.add(createCondition("language", "==", "한국어"));
        andArray1.add(createCondition("teamMember", ">=", 7));

        JSONArray andArray2 = new JSONArray();
        andArray2.add(createCondition("employmentDuration", ">=", "2022-01-01"));
        andArray2.add(createCondition("employmentEndDate", "<=", "2022-12-31"));
        andArray2.add(createCondition("employmentDays", ">=", 3));
        andArray2.add(createCondition("teamMember", ">=", 7));

        JSONArray andArray3 = new JSONArray();
        andArray3.add(createCondition("language", "==", "한국어"));
        andArray3.add(createCondition("employmentDays", ">=", 3));
        andArray3.add(createCondition("teamMember", ">=", 7));

        JSONObject orObject1 = new JSONObject();
        orObject1.put("and", andArray1);

        JSONObject orObject2 = new JSONObject();
        orObject2.put("or", andArray2);

        JSONObject orObject3 = new JSONObject();
        orObject3.put("and", andArray3);

        orArray.add(orObject1);
        orArray.add(orObject2);
        orArray.add(orObject3);

        mainJsonObject.put("or", orArray);

        // Print the result
        System.out.println("원래 JSON 형태 : " + mainJsonObject.toJSONString());
        System.out.println();
        System.out.println("쿼리문으로 만든 형태 : " + buildDynamicQuery(mainJsonObject));
    }
}
